//单例模式
//饿汉式：直接new对象，开发多见
public class Test1 
{
	//私有构造函数
	private Test1(){}
	//自行创建私有、静态的对象
	private static Test1 uniqueInstance1 = new Test1();
	//对外提供公共、静态的访问接口
	public static Test1 getInstance(){
		return uniqueInstance1;
}

//懒汉式
public class Test2
{
	//私有构造函数
	private Test2(){}
	//自行创建私有、静态的空对象
	private static Test2 uniqueInstance2 = null;
	//对外提供公共、静态的访问接口，并创建对象
	public static Test2 getInstance()
	{
		if(uniqueInstance2==null)
			uniqueInstance2 = new Test2();
		return uniqueInstance2;
	}
}
