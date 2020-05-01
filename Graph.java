import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {

	// Constants
	private final int ADJ_PLACEHOLDER = 1000;
	// Fields
		// Adjacency Matrix
	private int[][] adjMat;
		// Vertices Count
	private int roadCount;
		// Vertices Container
	private Town[] vertices;
	
	// Methods
	
	/**
	 * Constructor
	 */
	public Graph(int maxVertices)
	{
		adjMat = new int[maxVertices][maxVertices];
		
		// Initializes adjacency matrix elements to impossibly high values
		for (int i = 0; i < maxVertices; i++)
		{
			for (int j = 0; j < maxVertices; j++)
			{
				adjMat[i][j] = ADJ_PLACEHOLDER;
			}
		}
		
		roadCount = 0;
		vertices = new Town[maxVertices];
	}
	
	@Override
	public Road getEdge(Town source, Town destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Road addEdge(Town source, Town destination, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVertex(Town t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Town source, Town destination) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsVertex(Town t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Road> edgesOf(Town t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Road removeEdge(Town source, Town destination, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeVertex(Town t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> shortestPath(Town source, Town destination) {
		ArrayList<String> path = new ArrayList<>();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town source) {
		// TODO Auto-generated method stub
		
	}

}
