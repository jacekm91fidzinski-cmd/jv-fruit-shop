import service.FileReader;
import service.FileWriter;
import service.DataConverter;
import service.ShopService;
import service.ReportGenerator;
import service.OperationHandler;

import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.DataConverterImpl;
import service.impl.ShopServiceImpl;
import service.impl.ReportGeneratorImpl;

import strategy.*;
import model.FruitTransaction;

import java.util.*;

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
