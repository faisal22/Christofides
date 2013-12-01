/**
 *
 *
 * @author      Bjørn Harald Olsen
 * @author      Oscar Täckström
 * @version     1.0
 */

public class Edge implements Comparable {
    int from, to;
    double cost;

    public Edge(int _from, int _to, double _cost) {
				from = _from;
				to = _to;
				cost = _cost;
    }

    public int compareTo(Object _o) {
				Edge e = (Edge)_o;
				if(this.cost == e.cost) return 0;
				else if(this.cost > e.cost) return 1;
				else return -1;
    }

    public int getTo() {return to;}


    public int getFrom() {return from;}
}