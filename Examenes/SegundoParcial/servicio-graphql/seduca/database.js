const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('segundo_parcial', 'root', '', {
  host: 'localhost',
  port: '3307',
  dialect: 'mysql'
});

const Calificacion = sequelize.define('calificaciones', {
  ci: {
    type: Sequelize.STRING,
    allowNull: false,
    primaryKey: true
  },
  nombres: {
    type: Sequelize.STRING,
    allowNull: false
  },
  apellidos: {
    type: Sequelize.STRING,
    allowNull: false
  },
  esBachiller: {
    type: Sequelize.BOOLEAN,
  }
}, {
  tableName: 'calificaciones',
  timestamps: false
});

sequelize.sync();

module.exports = { sequelize, Calificacion };
