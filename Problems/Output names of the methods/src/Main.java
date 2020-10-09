class CreateInstance {

    public static SuperClass create() {

        SuperClass instance = new SuperClass() {

            @Override
            public void method2() {
                System.out.println("method2");
            }

            @Override
            public void method3() {
                System.out.println("method3");
            }
        };

        return instance;
    }
}


abstract class SuperClass {

    public static void method1() { }

    public void method2() { }

    public abstract void method3();
}