package com.example.demo;

import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-07-14 10:18 下午
 */
public class Response {

    Integer code;
    String msg;
    Data data;

}


class Data {

    MSG msg;
}

class MSG {

    Integer ErrCode;
    String Msg;
    Args args;
}

class Args {

    MaterialMsg materialMsg;
}

class MaterialMsg {

    List<String> ToUsers;
}