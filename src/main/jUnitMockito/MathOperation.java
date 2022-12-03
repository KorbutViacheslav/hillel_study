package jUnitMockito;

import java.util.Collections;

public class MathOperation {
    ItemSource itemSource;

    MathOperation(ItemSource itemSource) {
        this.itemSource = itemSource;
    }

    private void checkIfListIsEmpty() {
        if (itemSource.getItems().isEmpty()) {
            throw new IllegalStateException();
        }
    }

    int sum() {
        checkIfListIsEmpty();
        return itemSource.getItems().stream().mapToInt(Integer::intValue).sum();
    }

    int avg() {
        checkIfListIsEmpty();
        return sum() / itemSource.getItems().size();
    }

    int max() {
        checkIfListIsEmpty();
        return Collections.max(itemSource.getItems());
    }
}
