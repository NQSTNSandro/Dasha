package moduls;

import org.junit.jupiter.api.Test;
class InjectorTest {

    @Test
    void inject() {
        Bean bean=new Injector().inject(new Bean());
        bean.foo();

    }
}