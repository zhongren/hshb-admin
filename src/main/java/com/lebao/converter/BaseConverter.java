package com.lebao.converter;





import com.lebao.common.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zr
 * Date  : 2016/11/7 14:46
 */
public abstract class BaseConverter<P , V> {
	/**
	 * convert vo to po
	 * @param v
	 * @return
	 */
	public abstract P convert2P( V v );

	/**
	 * convert po to vo
	 * @param p
	 * @return
	 */
	public abstract V convert2V( P p ) ;

	/**
	 * convert all vo to po
	 * @param vs
	 * @return
	 */
	public List<P> convert2P( List<V> vs ){
		if( vs == null || CommonUtil.isEmpty( vs ) ) {
			return new ArrayList<P>()  ;
		}
		List< P > ps = new ArrayList<P>() ;
		for( V v : vs ){
			ps.add( convert2P( v ) ) ;
		}
		return ps ;
	}

	/**
	 * convert all po to vo
	 * @param ps
	 * @return
	 */
	public List<V> convert2V( List<P> ps ){
		if( ps == null || CommonUtil.isEmpty( ps ) ) {
			return new ArrayList<V>()  ;
		}
		List< V > vs = new ArrayList<V>() ;
		for( P p : ps ){
			vs.add( convert2V( p ) ) ;
		}
		return vs ;
	}
}
