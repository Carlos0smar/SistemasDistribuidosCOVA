<?php

namespace Database\Seeders;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\clima;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        // \App\Models\User::factory(10)->create();

        Clima::factory()->create([
            'fecha' => '04-06-24',
            'temperatura' => '21',
        ]);

        Clima::factory()->create([
            'fecha' => '05-06-24',
            'temperatura' => '22',
        ]);

        Clima::factory()->create([
            'fecha' => '06-06-24',
            'temperatura' => '25',
        ]);

        Clima::factory()->create([
            'fecha' => '07-06-24',
            'temperatura' => '26',
        ]);

        Clima::factory()->create([
            'fecha' => '08-06-24',
            'temperatura' => '28',
        ]);

        Clima::factory()->create([
            'fecha' => '09-06-24',
            'temperatura' => '19',
        ]);
        

        Clima::factory()->create([
            'fecha' => '10-06-24',
            'temperatura' => '22',
        ]);

        Clima::factory()->create([
            'fecha' => '11-06-24',
            'temperatura' => '12',
        ]);

        Clima::factory()->create([
            'fecha' => '12-06-24',
            'temperatura' => '18',
        ]);

        // \App\Models\User::factory()->create([
        //     'name' => 'Test User',
        //     'email' => 'test@example.com',
        // ]);
    }
}
