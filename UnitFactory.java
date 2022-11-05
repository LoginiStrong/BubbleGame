import java.util.*;
import java.text.*;
import java.io.*;

public abstract class UnitFactory {

   public abstract UnitFactory create(UnitFactory next);
}