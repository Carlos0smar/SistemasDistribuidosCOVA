const { v4: uuidv4 } = require('uuid');
const Libro = require('./Libro');
const Lector = require('./Lector');

const resolvers = {
  Query: {
    libros: async () => await Libro.findAll(),
    libro: async (_, { id }) => await Libro.findByPk(id),
    lectores: async () => await Lector.findAll({ include: Libro }),
    lector: async (_, { id }) => await Lector.findByPk(id, { include: Libro }),
  },
  Mutation: {
    agregarLibro: async (_, { titulo, autor }) => {
      return await Libro.create({ titulo, autor });
    },
    agregarLector: async (_, { nombre }) => {
      return await Lector.create({ nombre });
    },
    prestarLibro: async (_, { idLector, idLibro }) => {
      const lector = await Lector.findByPk(idLector);
      const libro = await Libro.findByPk(idLibro);

      if (lector && libro && libro.disponible) {
        await lector.addLibro(libro);
        libro.disponible = false;
        await libro.save();
        return lector;
      }

    },
    devolverLibro: async (_, { idLector, idLibro }) => {
      const lector = await Lector.findByPk(idLector);
      const libro = await Libro.findByPk(idLibro);

      if (lector && libro) {
        await lector.removeLibro(libro);
        libro.disponible = true;
        await libro.save();
        return lector;
      }

    },
  },
};

module.exports = resolvers;
