export interface User {
  id?: number;
  dni: string;
  nombres: string;
  apellidos: string;
  celular: string;
  correo: string;
  licencia: string;
  estado?: 'ACTIVE' | 'INACTIVE'
}