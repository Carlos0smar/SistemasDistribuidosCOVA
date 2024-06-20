const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('bd_clima', 'root', '', {
  host: 'localhost',
  dialect: 'mysql'
});

const Temperatura = sequelize.define('temperaturas', {
  fecha: {
    type: Sequelize.DATE,
  },
  temperatura: {
    type: Sequelize.INTEGER,
  },
}, {
  tableName: 'temperaturas',
  timestamps: false
});

sequelize.sync();

module.exports = { sequelize, Temperatura };
