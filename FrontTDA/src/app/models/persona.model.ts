export interface Persona{
    id:number;
    cedula:string;
    tipo_documento:string;
    nombres:string;
    apellidos:string;
    razon_social:string;
    direccion: string;
    telefono: string;
    email: string;
    estado: string;
    creado_por?: number;
    creado_en?: string;
    actualizado_por?: number;
    actualizado_en?: string;
}