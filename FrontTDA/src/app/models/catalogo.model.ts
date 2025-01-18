export interface Catalogo{
    id: number;
    tabla: number;
    item: number;
    descripcion_corta: string;
    descripcion_larga: string;
    estado?: string;
    creado_por?: number;
    creado_en?: string;
    actualizado_por?: number;
    actualizado_en?: string;
}