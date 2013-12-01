import java.util.*;

/**
 *
 *
 * @author      Bjørn Harald Olsen
 * @author      Oscar
 * @version     1.0
 */

public class GraphNode{
    ArrayList childList;
    int name;
    boolean visited;

    public GraphNode(int name){
                this.name=name;
                childList=new ArrayList();
                visited=false;
    }

    public boolean isVisited(){
                return visited;
    }

    public void setVisited(){
                visited=true;
    }

        public int getNumberOfChilds(){
                return childList.size();
    }

    public void setNotVisited(){
                visited=false;
    }

        public void addChild(GraphNode node){
                if(!(this.getName()==node.getName()) ){
                        childList.add(node);
                }
    }

        public void removeChild(GraphNode node){
                childList.remove(node);
    }


    public boolean hasMoreChilds(){
                return childList.size()>0;
    }

    public int getName(){
                return name;
    }

    public void getNextChild(int goal, Vector path, boolean firstTime){
                //om vi nått vårt mål så avsluta
                if(this.getName()==goal && !firstTime){
                        path.add(new Integer(this.getName()));
                }
                else{
                        //om fler vägar från denna nod, lägg till noden och fortsätt längs den första bästa av kanterna, plocka dessutom bort kanten.
                        if( childList.size()>0 ){
                                GraphNode tmpNode=(GraphNode)childList.remove(0);
                                tmpNode.removeChild(this); //ta bort kanten från andra hållet
                                path.add(new Integer(this.getName()));
                                tmpNode.getNextChild(goal,path,false);
                        }
                }
    }
}