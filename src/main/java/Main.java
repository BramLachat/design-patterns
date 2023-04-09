import boot.BootInitializer;
import client.UserInterfaceFactory;
import exception.ApplicationException;
import mediator.Mediator;
import parser.DataParserFactory;
import processor.DataProcessorFactory;
import reader.DataReaderFactory;

public class Main {
    public static void main(String[] args) throws ApplicationException {
        try {
            Mediator mediator = new Mediator();

            mediator.registerMediatorComponent(Mediator.ComponentTypes.BOOT_INITIALIZER, new BootInitializer(args));
            mediator.registerMediatorComponent(Mediator.ComponentTypes.USER_INTERFACE, new UserInterfaceFactory());
            mediator.registerMediatorComponent(Mediator.ComponentTypes.DATA_PARSER, new DataParserFactory());
            mediator.registerMediatorComponent(Mediator.ComponentTypes.DATA_READER, new DataReaderFactory());
            mediator.registerMediatorComponent(Mediator.ComponentTypes.DATA_PROCESSOR, new DataProcessorFactory());

            mediator.run();
        } catch (ApplicationException ae) {
            System.err.println(ae.getErrorMessage());
            throw ae;
        }
    }
}
