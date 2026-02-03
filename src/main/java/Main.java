import model.FruitTransaction;
import service.*;
import service.impl.*;
import strategy.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileReader reader = new FileReaderImpl();
        DataConverter converter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy);

        List<String> lines = reader.read("src/main/resources/input.csv");
        shopService.process(converter.convertToTransaction(lines));

        ReportGenerator generator = new ReportGeneratorImpl();
        FileWriter writer = new FileWriterImpl();
        writer.write(generator.getReport(), "src/main/resources/output.csv");
    }
}
