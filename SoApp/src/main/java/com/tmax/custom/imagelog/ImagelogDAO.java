package com.tmax.custom.imagelog;

import com.tmax.custom.datasoruce.DatabasePO21;
import com.tmax.proobject.service.imagelog.ImageLogDto;

@DatabasePO21
public interface ImagelogDAO {
	public void insert(ImageLogDto imageLogDto) throws Exception;
}
