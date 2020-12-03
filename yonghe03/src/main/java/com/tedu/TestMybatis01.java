package com.tedu;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;


/**
 * mybatis�����Ű���: ��ѯyonghedb.emp���е�����Ա����Ϣ
 */
public class TestMybatis01 {
	
	/* ��ϰ1: ��ѯemp�е�����Ա����Ϣ */
	@Test
	public void testFindAll01() throws Exception {
		//1.��ȡmybatis���������ļ�(mybatis-config.xml),Resources��mybatis�ṩ�Ĺ�����
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config2.xml");
		//2.ͨ��������Ϣ��ȡSqlSession��������
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build( in );
		//3.��ȡSQLSession����(�������ݿ������)
		SqlSession session = fac.openSession();
		//4.��ȡDoorMapper�ӿڵ�����ʵ��(mybatis�ṩ����,����������ʵ��)
		DoorMapper doorMapper = session.getMapper( DoorMapper.class );
		List<Door> list = doorMapper.findAll();
		//5.������
		for (Door door : list) {
			System.out.println( door );
		}
	}
}









