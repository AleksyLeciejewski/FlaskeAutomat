import Model.Bottle;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MainBuffer {

    private Queue<Bottle> bottleQueue = new priorityQueue<Bottle>() {

    };

    private class priorityQueue<T> implements Queue<Bottle> {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Bottle> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Bottle> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean add(Bottle bottle) {
            return false;
        }

        @Override
        public boolean offer(Bottle bottle) {
            return false;
        }

        @Override
        public Bottle remove() {
            return null;
        }

        @Override
        public Bottle poll() {
            return null;
        }

        @Override
        public Bottle element() {
            return null;
        }

        @Override
        public Bottle peek() {
            return null;
        }
    }
}
