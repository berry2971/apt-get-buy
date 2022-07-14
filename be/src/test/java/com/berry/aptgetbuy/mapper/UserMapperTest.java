package com.berry.aptgetbuy.mapper;

import com.berry.aptgetbuy.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void findById() throws Exception {
        User user1 = new User("id1", "pw1!", "name1", "01012345678", "서울", "동작", "여의도", null, null);
        User user2 = new User("id2", "pw2!", "name2", "01023456789", "부산", "동래", "안락", null, null);
        User user3 = new User("id3", "pw3!", "name3", "01034567890", "강원", "인제", "북", "원통", null);
        userMapper.save(user1);
        userMapper.save(user2);
        userMapper.save(user3);
        User findUser1 = userMapper.findById("id1");
        User findUser2 = userMapper.findById("id2");
        User findUser3 = userMapper.findById("id3");
        assertThat(user1.getPw()).isEqualTo(findUser1.getPw());
        assertThat(user2.getPw()).isEqualTo(findUser2.getPw());
        assertThat(user3.getPw()).isEqualTo(findUser3.getPw());
    }

    @Test
    void save() throws Exception {
        User user1 = new User("id1", "pw1!", "name1", "01012345678", "서울", "동작", "여의도", null, null);
        User user2 = new User("id2", "pw2!", "name2", "01023456789", "부산", "동래", "안락", null, null);
        User user3 = new User("id3", "pw3!", "name3", "01034567890", "강원", "인제", "북", "원통", null);
        userMapper.save(user1);
        userMapper.save(user2);
        userMapper.save(user3);
        List<User> users = userMapper.findAll();
        assertThat(users.size()).isEqualTo(3);
    }

    @Test
    void modifyUser() throws Exception {
        User user = new User("id1", "pw1!", "name1", "01012345678", "서울", "동작", "여의도", null, null);
        userMapper.save(user);
        user.setName("name2");
        user.setBmk_addr_lv4("village2");
        userMapper.modifyUser(user);

        User findUser = userMapper.findById("id1");
        assertThat(findUser.getName()).isEqualTo("name2");
        assertThat(findUser.getBmk_addr_lv4()).isEqualTo("village2");
    }

}
