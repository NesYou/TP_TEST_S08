import exceptions.PileVideException;
import exceptions.UnSeulElementException;

/**
 * Created by YohanBoichut on 09/03/2017.
 Interface d'une pile d'exécution ne contenant que des doubles
 */
public interface IPileExecution {


    /**
     *
     * @return la queue de la pile si c'est possible
     * @throws PileVideException
     */
    public IPileExecution getTail() throws PileVideException;

    /**
     *
     * @return la valeur de la cellule en tête de pile si c'est possible
     * @throws PileVideException
     */
    public double getCellValue() throws PileVideException;


    /**
     * Permet d'empiler un double sur la pile courante
     * @param e double à empiler
     * @return nouvelle pile
     */
    public IPileExecution push(double e);

    /**
     * Permet de dépiler un élément de la structure
     * @return la pile (avant l'appel) sans le premeir élément
     * @throws PileVideException
     */
    public IPileExecution pop()  throws PileVideException;

    /**
     * Permet de savoir combien de doubles sont dans la pile
     * @return le nombre de doubles
     */
    public int taille();

    /**
     * Soit une pile a::b::pile
     * @return (a+b)::pile
     * @throws PileVideException si aucun élément dans la pile
     * @throws UnSeulElementException si un seul élément dans la pile
     */
    public IPileExecution add() throws PileVideException, UnSeulElementException;

    /**
     * Soit une pile a::b::pile
     * @return (a-b)::pile
     * @throws PileVideException si aucun élément dans la pile
     * @throws UnSeulElementException si un seul élément dans la pile
     */

    public IPileExecution minus() throws PileVideException, UnSeulElementException;

    /**
     * Soit une pile a::b::pile
     * @return (a*b)::pile
     * @throws PileVideException si aucun élément dans la pile
     * @throws UnSeulElementException si un seul élément dans la pile
     */

    public IPileExecution times() throws PileVideException, UnSeulElementException;

    /**
     * Soit une pile a::b::pile
     * @return (a/b)::pile
     * @throws PileVideException si aucun élément dans la pile
     * @throws UnSeulElementException si un seul élément dans la pile
     */

    public IPileExecution div() throws PileVideException, UnSeulElementException;

    public IFabriquePile getFabrique();



}
