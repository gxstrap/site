package com.rpc.biz.mapper;

import java.util.List;

import com.rpc.biz.model.QrtzTriggers;

public interface QrtzTriggersMapper extends BaseMapper<String, QrtzTriggers> {

    List<QrtzTriggers> findAll(QrtzTriggers qrtzTriggers);

}
