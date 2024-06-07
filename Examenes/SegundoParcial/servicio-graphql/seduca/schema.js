const { GraphQLObjectType, GraphQLString, GraphQLSchema, GraphQLList, GraphQLNonNull, GraphQLBoolean } = require('graphql');
const { Calificacion } = require('./database');

const CalificacionType = new GraphQLObjectType({
  name: 'calificaciones',
  fields: {
    ci: { type: GraphQLString },
    nombres: { type: GraphQLString },
    apellidos: { type: GraphQLString },
    esBachiller: { type: GraphQLBoolean }
  }
});

const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    Calificacion: {
      type: new GraphQLList(CalificacionType),
      resolve(parent, args) {
        return Calificacion.findAll();
      }
    },
    calificacion: {
      type: CalificacionType,
      args: { ci: { type: GraphQLString } },
      resolve(parent, args) {
        return Calificacion.findByPk(args.ci);
      }
    }
  }
});

const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    addCalificacion: {
      type: CalificacionType,
      args: {
        ci: { type: new GraphQLNonNull(GraphQLString) },
        nombres: { type: new GraphQLNonNull(GraphQLString) },
        apellidos: { type: new GraphQLNonNull(GraphQLString) },
        esBachiller: { type: new GraphQLNonNull(GraphQLBoolean) }
      },
      resolve(parent, args) {
        return Calificacion.create({
          ci: args.ci,
          nombres: args.nombres,
          apellidos: args.apellidos,
          esBachiller: args.esBachiller
        });
      }
    },
    updateCalificacion: {
      type: CalificacionType,
      args: {
        ci: { type: new GraphQLNonNull(GraphQLString) },
        nombres: { type: GraphQLString },
        apellidos: { type: GraphQLString },
        esBachiller: { type: GraphQLBoolean }
      },
      resolve(parent, args) {
        return Calificacion.findByPk(args.ci)
          .then(calificacion => {
            if (!calificacion) {
              throw new Error('Calificacion no encontrada');
            }
            return Calificacion.update({
              nombres: args.nombres !== undefined ? args.nombres : calificacion.nombres,
              apellidos: args.apellidos !== undefined ? args.apellidos : calificacion.apellidos,
              sexo: args.esBachiller !== undefined ? args.esBachiller : calificacion.esBachiller
            });
          });
      }
    }
  }
});

module.exports = new GraphQLSchema({
  query: RootQuery,
  mutation: Mutation
});
