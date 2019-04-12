package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que genera las lista que se usan en la aplicacion.
 */
public class RellenaSemillas {
	private List<String> PreguntasENT= new ArrayList<>();
	private List<Integer> RespuestaBuenaENT= new ArrayList<>();
	private List<Integer> RespuestaMala1ENT= new ArrayList<>();
	private List<Integer> RespuestaMala2ENT= new ArrayList<>();
	private List<String> Preguntas= new ArrayList<>();
	private List<Integer> RespuestaBuena= new ArrayList<>();
	private List<Integer> RespuestaMala1= new ArrayList<>();
	private List<Integer> RespuestaMala2= new ArrayList<>();
    /**
     * Metodo que genera las lista de PreguntasENT,RespuestaBuenaENT,RespuestaMala1ENT,RespuestaMala2ENT,Preguntas,RespuestaBuena,RespuestaMala1,RespuestaMala2.
     */
	public void generar() {        
        for(int i=0;i<1000;i++){
          int o1=(int) (Math.random()*100);
          int o2=(int) (Math.random()*100);
          int op=(int) (Math.random()*10);
          int resultado=0;
          if(op>4){
              String pregunta= o1+" + "+o2+" =";
              Preguntas.add(i, pregunta);
              resultado=o1+o2;
              RespuestaBuena.add(i,resultado);
              
          }else{
              String pregunta= o1+" - "+o2+" =";
              Preguntas.add(i, pregunta);
              resultado=o1-o2;
              RespuestaBuena.add(i,resultado);
          }
          
          int basura=(int) (Math.random()*10)-5;
          if(basura==0){
              basura=1;
          }
          RespuestaMala1.add(i,basura+resultado);
          
          int basura2=(int) (Math.random()*10)-5;
          if(basura2==0){
              basura2=1;
          }
          if(basura==basura2){
              basura2++;
          }
          RespuestaMala2.add(i,basura2+resultado);
        }
        
        for(int i=0;i<1000;i++){
          int o1=(int) (Math.random()*100);
          int o2=(int) (Math.random()*100);
          int op=(int) (Math.random()*10);
          int resultado=0;
          if(op>4){
              String pregunta= o1+" + "+o2+" =";
              PreguntasENT.add(i, pregunta);
              resultado=o1+o2;
              RespuestaBuenaENT.add(i,resultado);
              
          }else{
              String pregunta= o1+" - "+o2+" =";
              PreguntasENT.add(i, pregunta);
              resultado=o1-o2;
              RespuestaBuenaENT.add(i,resultado);
          }
          
          int basura=(int) (Math.random()*10)-5;
          if(basura==0){
              basura=1;
          }
          RespuestaMala1ENT.add(i,basura+resultado);
          int basura2=(int) (Math.random()*10)-5;
          if(basura2==0){
              basura2=1;
          }
          if(basura==basura2){
              basura2++;
          }
          RespuestaMala2ENT.add(i,basura2+resultado);
        }
        
        for(int i=1000;i<2000;i++){
          int o1=(int) (Math.random()*10000);
          int o2=(int) (Math.random()*10000);
          int op=(int) (Math.random()*10);
          int resultado=0;
          if(op>4){
              String pregunta= o1+" + "+o2+" =";
              Preguntas.add(i, pregunta);
              resultado=o1+o2;
              RespuestaBuena.add(i,resultado);
              
          }else{
              String pregunta= o1+" - "+o2+" =";
              Preguntas.add(i, pregunta);
              resultado=o1-o2;
              RespuestaBuena.add(i,resultado);
          }
          
          int basura=(int) (Math.random()*100)-50;
          if(basura==0){
              basura=1;
          }
          RespuestaMala1.add(i,basura+resultado);
          
          int basura2=(int) (Math.random()*100)-50;
          if(basura2==0){
              basura2=1;
          }
          if(basura==basura2){
              basura2++;
          }
          RespuestaMala2.add(i,basura2+resultado);
        }
        
          for(int i=1000;i<2000;i++){
          int o1=(int) (Math.random()*10000);
          int o2=(int) (Math.random()*10000);
          int op=(int) (Math.random()*10);
          int resultado=0;
          if(op>4){
              String pregunta= o1+" + "+o2+" =";
              PreguntasENT.add(i, pregunta);
              resultado=o1+o2;
              RespuestaBuenaENT.add(i,resultado);
              
          }else{
              String pregunta= o1+" - "+o2+" =";
              PreguntasENT.add(i, pregunta);
              resultado=o1-o2;
              RespuestaBuenaENT.add(i,resultado);
          }
          
          int basura=(int) (Math.random()*100)-50;
          if(basura==0){
              basura=1;
          }
          RespuestaMala1ENT.add(i,basura+resultado);
          
          int basura2=(int) (Math.random()*100)-50;
          if(basura2==0){
              basura2=1;
          }
          if(basura==basura2){
              basura2++;
          }
          RespuestaMala2ENT.add(i,basura2+resultado);
        }
        
    for(int i=2000;i<3000;i++){
          int o1=(int) (Math.random()*10000);
          int op=(int) (Math.random()*10);
          int resultado=0;
          if(op>4){
        	  int o2=(int) (Math.random()*10000);
        	  if(o2==0){
                  o2=5400;
              }
              String pregunta= o1+" * "+o2+" =";
              Preguntas.add(i, pregunta);
              resultado=o1*o2;
              RespuestaBuena.add(i,resultado);
              
          }else{
        	  int o2=(int) (Math.random()*100);
        	  if(o2==0){
                  o2=54;
              }
              String pregunta= o1+" / "+o2+" =";
              Preguntas.add(i, pregunta);
              resultado=o1/o2;
              RespuestaBuena.add(i,resultado);
          }
          
          int basura=(int) (Math.random()*10)-5;
          if(basura==0){
              basura=1;
          }
          RespuestaMala1.add(i,basura+resultado);
          
          int basura2=(int) (Math.random()*10)-5;
          if(basura2==0){
              basura2=1;
          }
          if(basura==basura2){
              basura2++;
          }
          RespuestaMala2.add(i,basura2+resultado);
        }
            
    for(int i=2000;i<3000;i++){
          int o1=(int) (Math.random()*100);
          
          int op=(int) (Math.random()*10);
          int resultado=0;
          if(op>4){
        	  int o2=(int) (Math.random()*10000);
              if(o2==0){
                  o2=5400;
              }
              String pregunta= o1+" * "+o2+" =";
              PreguntasENT.add(i, pregunta);
              resultado=o1*o2;
              RespuestaBuenaENT.add(i,resultado);
          }else{
        	  int o2=(int) (Math.random()*100);
              if(o2==0){
                  o2=54;
              }
              String pregunta= o1+" / "+o2+" =";
              PreguntasENT.add(i, pregunta);
              resultado=o1/o2;
              RespuestaBuenaENT.add(i,resultado);
          }
          
          int basura=(int) (Math.random()*10)-5;
          if(basura==0){
              basura=1;
          }
          RespuestaMala1ENT.add(i,basura+resultado);
          
          int basura2=(int) (Math.random()*10)-5;
          if(basura2==0){
              basura2=1;
          }
          if(basura==basura2){
              basura2++;
          }
          RespuestaMala2ENT.add(i,basura2+resultado);
        }
    }
	/**
	 * Metodo que devuelve la lista con las preguntas del modo entrenamiento.
	 * @return Lista con las preguntas del modo entrenamiento.
	 */
	public List<String> getPreguntasENT() {
		return PreguntasENT;
	}
	/**
	 * Metodo que devuelve la lista con las preguntas buenas del modo entrenamiento.
	 * @return Lista con las preguntas buenas del modo entrenamiento.
	 */
	public List<Integer> getRespuestaBuenaENT() {
		return RespuestaBuenaENT;
	}
	/**
	 * Metodo que devuelve la lista con las preguntas malas1 del modo entrenamiento.
	 * @return Lista con las preguntas malas1 del modo entrenamiento.
	 */
	public List<Integer> getRespuestaMala1ENT() {
		return RespuestaMala1ENT;
	}

	public List<Integer> getRespuestaMala2ENT() {
		return RespuestaMala2ENT;
	}
	/**
	 * Metodo que devuelve la lista con las preguntas.
	 * @return Lista con las preguntas.
	 */
	public List<String> getPreguntas() {
		return Preguntas;
	}
	/**
	 * Metodo que devuelve la lista con las preguntas buenas del modo Clasico.
	 * @return Lista con las preguntas buenas del modo Clasico.
	 */
	public List<Integer> getRespuestaBuena() {
		return RespuestaBuena;
	}
	/**
	 * Metodo que devuelve la lista con las preguntas malas1 del modo Clasico.
	 * @return Lista con las preguntas malas1 del modo Clasico.
	 */
	public List<Integer> getRespuestaMala1() {
		return RespuestaMala1;
	}
	/**
	 * Metodo que devuelve la lista con las preguntas malas2 del modo Clasico.
	 * @return Lista con las preguntas malas2 del modo Clasico.
	 */
	public List<Integer> getRespuestaMala2() {
		return RespuestaMala2;
	}

}
