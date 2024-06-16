const { DataTypes } = require('sequelize');
const sequelize = require('./db');
const Libro = require('./Libro');

const Lector = sequelize.define('Lector', {
  id: {
    type: DataTypes.UUID,
    defaultValue: DataTypes.UUIDV4,
    primaryKey: true,
  },
  nombre: {
    type: DataTypes.STRING,
    allowNull: false,
  },
}, {
  tableName: 'lectores',
});

Lector.belongsToMany(Libro, { through: 'LibrosPrestados' });
Libro.belongsToMany(Lector, { through: 'LibrosPrestados' });

module.exports = Lector;
