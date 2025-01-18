export interface Sede{
    id:number;
    nombre: string;
    direccion:string;
    ciudad:string;
    ciudadDesc?:string;
    pais:string;
    paisDesc?:string;
    departamento:string;
    departamentoDesc?:string;
    telefono:string;
    estado:string;
    creado_por: number;
    creado_en: String;
    actualizado_por: number;
    actualizado_en: String;
}