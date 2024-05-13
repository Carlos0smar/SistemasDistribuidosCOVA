<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Factura>
 */
class FacturaFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'nro' => fake() -> randomNumber(5, true),
            'fecha' => fake() -> date(),
            'cuf' => fake() -> bothify('??????'),
            'cufd'=> fake() -> bothify('??????'),
            'monto_total' => fake() -> randomFloat(2, 30, 100),
        ];
    }
}
