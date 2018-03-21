package bridge;
/*
  桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化。
  老实说，我不知道对于桥接模式和对于面向接口开发有什么不同，开发过程中完全面向接口开发，忽略具体的实现，只有在具体的场景中我们才能确认具体的实现，
  而这实现就可以随机变话了。

  接口确认行为和参数，确定流程，但是具体的实现。其实这和策略模式有什么不同呢？实际接口层实现和具体实现没有什么关系，只是定义了许多接口，而具体的是通过接口的实现
  来展现业务。接口实现和业务并没有什么关系，只负责实现逻辑，相互改变并不会影响。但是感觉这和很多的模式不一而谋啊，这有什么值得大写特写的吗？

 */