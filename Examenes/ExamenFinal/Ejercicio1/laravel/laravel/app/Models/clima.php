<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class clima extends Model
{
    use HasFactory;

    protected $fillable = [
        'fecha',
        'temperatura',
    ];
}
