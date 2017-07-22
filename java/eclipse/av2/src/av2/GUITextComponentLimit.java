package av2;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class GUITextComponentLimit extends PlainDocument
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int charactersLimit;

    private GUITextComponentLimit(int charactersLimit)
    {
        this.charactersLimit = charactersLimit;
    }

    @Override
    public void insertString(int offset, String input, AttributeSet attributeSet) throws BadLocationException
    {
        if (isAllowed(input))
        {
            super.insertString(offset, input, attributeSet);
        } else
        {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private boolean isAllowed(String string)
    {
        return (getLength() + string.length()) <= charactersLimit;
    }

    public static void addTo(JTextComponent textComponent, int charactersLimit)
    {
        GUITextComponentLimit textFieldLimit = new GUITextComponentLimit(charactersLimit);
        textComponent.setDocument(textFieldLimit);
    }
}