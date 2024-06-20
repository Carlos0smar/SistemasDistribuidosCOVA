<?php

namespace App\Http\Controllers;

use App\Models\clima;
use Illuminate\Http\Request;

class ClimaController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $temperaturas=clima::all();
        return $temperaturas;
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $clima=Clima::create($request->all());
        return $clima;
    }

    /**
     * Display the specified resource.
     */
    public function show($clima)
    {
        $clima=Clima::find($clima);
        return $clima;
    }


    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, $clima)
    {
        $clima=Clima::find($clima);
        $clima->update($request->all());
        return $clima;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy( $clima)
    {
        $clima=Clima::find($clima);
        $clima->delete();
        return $clima;
    }
}
