package cn.itcast.demo;
/*
 *  ͨ���߳�����,���ְ�ȫ����
 *  �����ȫ����,Java����,�ṩ����,ͬ������
 *  ��ʽ:
 *    synchronized(�������){
 *      �߳�Ҫ�����Ĺ�������
 *    }
 *    ͬ�������
 */
public class Tickets implements Runnable{
	
	//������۵�ƱԴ
	private int ticket = 100;
	private Object obj = new Object();
	
	public void run(){
		while(true){
			//�̹߳�������,��֤��ȫ,����ͬ�������
			synchronized(obj){
			//��Ʊ���ж�,����0,���Գ���,����--����
				if( ticket > 0){
					try{
					   Thread.sleep(10);
					}catch(Exception ex){}
					System.out.println(Thread.currentThread().getName()+" ���۵� "+ticket--);
				}
			}
		}
	}
}