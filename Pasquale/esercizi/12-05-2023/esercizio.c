item getBottom_tail(stack a, item previous, item el) {
    previous = top(a);
    pop(a);
    if (emptyStack(a)) {
        return el;
    }
    else {
        el = getBottom(a, previous, el);
        push(previous, a);
        return el;
    }
}