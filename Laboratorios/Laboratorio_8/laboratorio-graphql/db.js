const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('biblioteca_graphql', 'root', '', {
  host: 'localhost',
  port: 3306,
  dialect: 'mysql',
});

sequelize.authenticate()
  .then(() => {
    console.log('Conexión a la base de datos exitosa.');
  })
  .catch(err => {
    console.error('Error al conectar a la base de datos:', err);
  });

module.exports = sequelize;
