export interface Envio{
    id:number;
    codigo:string;
    tipoEnvio:string;
    idUsuario:number;
    idEmpleado?:number;
    estado:string;
    creado_por?: number;
    creado_en?: string;
    actualizado_por?: number;
    actualizado_en?: string;
}