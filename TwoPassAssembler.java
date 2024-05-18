import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TwoPassAssembler {
    private Map<String, Integer> symbolTable;

    public TwoPassAssembler() {
        this.symbolTable = new HashMap<>();
    }

    public void assemble(String fileName) throws IOException {
        // First pass
        int locationCounter = 0;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+");
            if (parts.length > 0) {
                if (parts[0].equals("ORG")) {
                    locationCounter = Integer.parseInt(parts[1]);
                } else if (!parts[0].startsWith("//")) {
                    symbolTable.put(parts[0], locationCounter);
                    locationCounter++;
                }
            }
        }
        br.close();

        // Second pass
        br = new BufferedReader(new FileReader(fileName));
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+");
            if (parts.length > 0 && !parts[0].startsWith("//")) {
                if (!parts[0].equals("ORG")) {
                    String instruction = parts[0];
                    if (symbolTable.containsKey(instruction)) {
                        int address = symbolTable.get(instruction);
                        System.out.println(address + ": " + line);
                    } else {
                        System.out.println("Error: Undefined symbol - " + instruction);
                    }
                }
            }
        }
        br.close();
    }

    public static void main(String[] args) {
        TwoPassAssembler assembler = new TwoPassAssembler();
        try {
            assembler.assemble("assembly_code.asm");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
