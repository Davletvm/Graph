import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Graph g = readData("data.txt");
		for(int i = 0; i < g.getVertexCount(); i++){
			System.out.print("vertex " + i + " connected with: ");
			for(Integer vertex : g.adj(i)){
				System.out.print(vertex + ", ");
			}
			System.out.println();
		}
	}
	
	private static Graph readData(String pathToFile) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File(pathToFile)));
		String line;
		Graph graph = new Graph(Integer.valueOf(br.readLine()));
		int graphVertex = 0;
		while((line = br.readLine()) != null){
			String[] array = line.split(",");
			for(int i = 0; i < array.length; i++){
				graph.addEdge(graphVertex, Integer.valueOf(array[i]));
			}
			graphVertex++;
		}
		br.close();
		return graph;
	}
}
