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

//懒汉式之并发访问
class Single
{
	private Single(){}
	private static Single s = null;
	/*
	并发访问有安全隐患，所以加入同步机制解决安全问题
	但是，同步的出现却降低了效率。
	提高效率：减少判断锁的次数，可以通过双重判断的方式。
	*/
	public static void getInstance()
	{
		if(s==null)
		{
			synchronized(Single.class){
				if(s==null)
					s = new Single();
				return s;
			}
		}
	}
}