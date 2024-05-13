<?php

namespace App\Http\Controllers;

use App\Models\Factura;
use Illuminate\Http\Request;

class FacturaController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $facturas = Factura::all();
        return $facturas;
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        
        $request->validate([
            'nro' => 'required|integer|max:30',
            'fecha' => 'required|max:30',
            'cuf' => 'required|string|max:30',
            'cufd' => 'required|string|max:30',
            'monto_total' => 'required|max:30',
        ]);
        $factura=Factura::create($request->all());
        return $factura;        
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $factura=Factura::find($id);
        return $factura;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $factura=Factura::find($id);
        $factura->update($request->all());
        return $factura;

    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $factura=Factura::find($id);
        $factura->delete();
        return $factura;
    }
}
