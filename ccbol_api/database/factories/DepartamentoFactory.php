<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Departamento>
 */
class DepartamentoFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'nombre' => fake() -> randomElement(["Chuquisaca", "La Paz", "Beni", "Tarija", "Potosi", "Oruro", "Pando", "Santa Cruz", "Cochabamba" ]),
            'codigo' => fake() -> randomNumber(7, true),
            'cantidad_paritcipantes' => fake() -> randomNumber(5, true),
            'region' => fake() -> randomElement(["Región Andina", "Región Amazónica", "Región del Chaco"]),
        ];
    }
}
