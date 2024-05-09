<?php

namespace App\Http\Controllers;
use App\Models\Departamento;

use Illuminate\Http\Request;

class DepartamentosController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $departamentos=Departamento::all();
        return $departamentos;
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $departamento=Departamento::create($request->all());
        return $departamento;
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $departamento=Departamento::find($id);
        return $departamento;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $departamento=Departamento::find($id);
        $departamento->update($request->all());
        return $departamento;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $departamento=Departamento::find($id);
        $departamento->delete();
        return $departamento;
    }
}
