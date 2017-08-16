/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
package ps0;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * This is a container can be used to contain Balls. The key
 * difference between a BallContainer and a Box is that a Box has a
 * finite capacity. Once a box is full, we cannot put in more Balls.
 */
public class Box extends BallContainer implements Iterable<Ball> {

    BallContainer ballContainer;
    double maxCapacity;

    /**
     * Constructor that creates a new box.
     * @param capacity Total capacity of balls that this box can contain.
     */
    public Box(double capacity) {
        ballContainer = new BallContainer();
        maxCapacity = capacity;
    }
    
    /**
     * This method replaces (overrides) the <tt>add(Ball)</tt> method
     * in <tt>BallContainer</tt>, because we have to check if the
     * <tt>Box</tt> has enough remaining space when we try to put a
     * Ball inside. Hence, this method returns true if a ball is
     * successfully added to the box, i.e., ball is not already in the
     * box and if the box is not already full; and it returns false,
     * if ball is already in the box or if the box is too full to
     * contain the new ball.
     * @param b Ball to be added.
     * @return true if ball was successfully added to the box,
     * i.e. ball is not already in the box and if the box is not
     * already full. Returns false, if ball is already in the box or
     * if the box is too full to contain the new ball.
     */
    public boolean add(Ball b) {
        if (maxCapacity < ballContainer.getCapacity() + b.getCapacity() || ballContainer.contains(b)) return false;
        ballContainer.add(b);
        return true;
    }

    public boolean remove(Ball b) {
        return ballContainer.remove(b);
    }

    public double getCapacity() {
        return ballContainer.getCapacity();
    }

    public int size() {
        return ballContainer.size();
    }

    public void clear() {
        ballContainer.clear();
    }

    public boolean contains(Ball b) {
        return ballContainer.contains(b);
    }

    /**
     * This method returns an iterator that returns all the balls in
     * this box in ascending size, i.e., return the smallest Ball
     * first, followed by Balls of increasing size.
     * @return an iterator that returns all the balls in this box in
     * ascending size.
     */
    public Iterator<Ball> getBallsFromSmallest() {
        TreeSet<Ball> tree = new TreeSet<Ball>(new ballComparator());
        Iterator<Ball> iter = iterator();
        while (iter.hasNext()) tree.add(iter.next());
        return tree.iterator();
    }

    @Override
    public Iterator<Ball> iterator() {
        return ballContainer.iterator();
    }

    public class ballComparator implements Comparator<Ball> {

        @Override
        public int compare(Ball b1, Ball b2) {
            return Double.compare(b1.getCapacity(), b2.getCapacity());
        }

    }

}
