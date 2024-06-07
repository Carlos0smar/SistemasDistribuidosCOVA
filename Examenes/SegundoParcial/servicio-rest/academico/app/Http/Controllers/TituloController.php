<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Titulo;

class TituloController extends Controller
{
    public function index()
    {
        $titulo=Titulo::all();
        return $titulo;
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $titulo=Titulo::create($request->all());
        return $titulo;
        
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $titulo=Titulo::find($id);
        
        return $titulo;

    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $titulo=Titulo::find($id);
        $titulo->update($request->all());
        return $titulo;

    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $titulo=Titulo::find($id);
        $titulo->delete();
        return $titulo;
    }
}
