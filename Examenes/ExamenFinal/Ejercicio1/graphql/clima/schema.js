const { GraphQLObjectType, GraphQLString, GraphQLSchema, GraphQLList, GraphQLNonNull, GraphQLBoolean } = require('graphql');
const { Clima } = require('./database');

const ClimaType = new GraphQLObjectType({
  name: 'clima',
  fields: {
    fecha: { type: GraphQlDate },
    temperatura: { type: GraphQLString },
  }
});

const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    Clima: {
      type: new GraphQLList(ClimaType),
      resolve(parent, args) {
        return Clima.findAll();
      }
    },
    Clima: {
      type: ClimaType,
      args: { fecha: { type: GraphQLString } },
      resolve(parent, args) {
        return Clima.findByPk(args.fecha);
      }
    }
  }
});

const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    addClima: {
      type: ClimaType,
      args: {
        fecha: { type: new GraphQLNonNull(GraphQlDate) },
        temperatura: { type: new GraphQLNonNull(GraphQLInteger) },
      },
      resolve(parent, args) {
        return Clima.create({
          fecha: args.fecha,
          temperatura: args.temperatura,
        });
      }
    },
    updateClima: {
      type: ClimaType,
      args: {
        fecha: { type: new GraphQLNonNull(GraphQLString) },
        temperatura: { type: GraphQLInteger },
      },
      resolve(parent, args) {
        return Clima.findByPk(args.id)
          .then(clima => {
            if (!clima) {
              throw new Error('Fecha no encontrada');
            }
            return Clima.update({
              fecha: args.fecha !== undefined ? args.fecha : clima.fecha,
              temperatura: args.temperatura !== undefined ? args.temperatura : clima.temperatura,
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
