package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA",10000,100);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findAll() {
        //given
        Item item = new Item("itemA",10000,100);
        Item item2 = new Item("itemB",10000,100);
        //when
        itemRepository.save(item);
        itemRepository.save(item2);
        //then
        List<Item> all = itemRepository.findAll();

        Assertions.assertThat(all.size()).isEqualTo(2);
        Assertions.assertThat(all).contains(item,item2);
    }

    @Test
    void updateItem() {
        //given
        Item item = new Item("itemA",10000,100);
        //when
        Item saveItem = itemRepository.save(item);
        //then
        itemRepository.update(saveItem.getId(),new Item("itemB",20000,200));

        Assertions.assertThat(saveItem.getItemName()).isEqualTo("itemB");
        Assertions.assertThat(saveItem.getPrice()).isEqualTo(20000);
        Assertions.assertThat(saveItem.getQuantity()).isEqualTo(200);

    }

}