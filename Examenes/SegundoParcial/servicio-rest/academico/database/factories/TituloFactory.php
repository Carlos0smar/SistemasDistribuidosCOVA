<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Titulo>
 */
class TituloFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'ci'=>fake()->numberBetween(1111111,99999999),
            'nombrecompleto'=>fake()->firstName(),
            'titulo'=>fake()->word(),
            'fecha_emision'=>fake()->date()
        ];
    }
}
