package cola;
// cola circular 3
class ColaArreglo{
	Object[] ArregloCola;
        int primero=-1,ultimo=-1; //declaración cola principal
        Object[] ArregloColaux; 
        int primeroaux=-1,ultimoaux=-1; //declarar cola auxiliar
	int Num_elem;
        int Num_elemaux;
	int Cant_elem=5;
        int Cant_elem2=5; //tamaño del arreglo cola
        float pro=0;
            
	
	//Constructor
	ColaArreglo(){
		ArregloCola=new Object[Cant_elem];
                ArregloColaux =new Object[Cant_elem2];
                primeroaux=-1;
		ultimoaux=-1;
		Num_elemaux=0;
		primero=-1;
		ultimo=-1;
		Num_elem=0;
	}

        public boolean llena(){
            //primero y último en los extremos
            if ((primero==0)&&(ultimo==Cant_elem-1)) 
                return(true);
            if (ultimo+1==primero) //último más uno alcanza a primero
                return (true);
            return(false);
        }

	//Encola un elemento
	public void Ingresar(Object x)
        {
		if((ultimo==-1)&&(primero==-1)) 
                {
                        primero++;
			ultimo++;
                        //en la posición de último en ArregloCola se
                        //guarda el dato X
			ArregloCola[ultimo]=x; 
         	}
		else{
			if(llena())
				System.out.println("No hay campo");
			else
                            if (ultimo==Cant_elem-1)
                                ultimo=0;
                            else
                                ultimo++;
                        ArregloCola[ultimo]=x;
			}
	}

    //Desencola un elemento
	public Object Avanzar(){
            Object dato=null;
		if(VaciaCola())
			System.out.println("No hay Elementos");
		else{
                    dato=ArregloCola[primero];
                    if (primero == ultimo){
                        primero=-1;
                        ultimo=-1;
                        }
                    else{
                        if (primero==Cant_elem-1)
                            primero=0;
                        else
                            primero++;
                    }
		}
            return(dato);
	}

    public void Ingresaraux(Object x)
        {
		if(ultimoaux==-1)
                {
			ultimoaux++;
                        primeroaux++;
			ArregloColaux[ultimoaux]=x;
		}
		else{
			ultimoaux++;
			if(ultimoaux==Cant_elem2)
				System.out.println("No hay campo");
			else
				ArregloColaux[ultimoaux]=x;
			}
	}

    public Object Avanzaraux(){
            Object dato=null;
		if(VaciaColaux())
			System.out.println("No hay Elementos");
		else{
                    dato=ArregloColaux[primeroaux];
                    if (primeroaux == ultimoaux){
                        primeroaux=-1;
                        ultimoaux=-1;
                        }
                    else{
                        primeroaux++;
                    }
		}
            return(dato);
	}

    //Imprime al cola
    public void Imprimir(){
        Object desplazar2;
        if(VaciaCola())
            System.out.println("No hay Elementos");
        else{
            System.out.println("La cola es:");
            while(!VaciaCola()){
                desplazar2=Avanzar();
                
                Ingresaraux(desplazar2);
            }
            while(!VaciaColaux()){
                desplazar2=Avanzaraux();
                System.out.print(desplazar2+"\t");
                Ingresar(desplazar2);
            }
            System.out.println("");
	}
    }
	//Retorna si esta vacia la cola
	public boolean VaciaColaux(){
		return (ultimoaux==-1 && primeroaux==-1);
	}

	//Retorna si esta vacia la cola 2
	public boolean VaciaCola(){
		return (ultimo==-1 && primero==-1);
	}
        public void Contar(){
            Object desplazar2;
            int cont=0;
            System.out.println("La cola es:");
            while(!VaciaCola()){
                desplazar2=Avanzar();
                Ingresaraux(desplazar2);
               
             }
            while(!VaciaColaux()){
                desplazar2=Avanzaraux();
                cont ++;
                Ingresar(desplazar2);
            }
            System.out.println("numero de datos es:"+cont);
	}

	}

class colaA{
	public static void main(String[]args){
		ColaArreglo nuevo=new ColaArreglo();
		nuevo.Ingresar("9");
		nuevo.Ingresar("13");
		//nuevo.Ingresar("11");
		//nuevo.Ingresar("12");
		nuevo.Ingresar("13");
		nuevo.Avanzar();
                nuevo.Imprimir();
		nuevo.Ingresar("1133");
                nuevo.Imprimir();
                nuevo.Contar();
                               
          
                             
    }
}
		
