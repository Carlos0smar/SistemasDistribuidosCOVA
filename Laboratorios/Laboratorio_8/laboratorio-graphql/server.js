const { ApolloServer } = require('apollo-server');
const typeDefs = require('./schema');
const resolvers = require('./resolvers');
const sequelize = require('./db');

const server = new ApolloServer({ typeDefs, resolvers });

sequelize.sync().then(() => {
  server.listen().then(({ url }) => {
    console.log(`Server: ${url}`);
  });
});
