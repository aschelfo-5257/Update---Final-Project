import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Simple in-memory storage for blocks
@WebServlet("/blockcraft")
public class BlockCraftServlet extends HttpServlet {
    private static final Map<String, String> blockData = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson(blockData)); // Using Gson for JSON serialization
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String z = request.getParameter("z");
        String blockType = request.getParameter("blockType");

        if (x != null && y != null && z != null && blockType != null) {
            String blockId = x + "_" + y + "_" + z;
            blockData.put(blockId, blockType); // Store block
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters for block placement.");
        }
    }
}
