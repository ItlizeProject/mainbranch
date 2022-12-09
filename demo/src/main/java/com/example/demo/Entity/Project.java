package com.example.demo.Entity;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="project_id", unique = true)
    private Long ProjectId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	@JsonIgnore
	@JoinColumn(name = "userId", referencedColumnName = "user_id")
	private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = ProjectProduct.class)
    @JsonIgnore
    private List<ProjectProduct> ProjectProduct;

    //create constructor
    public Project(){

    }
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public Long getProjectId() {
        return ProjectId;
    }

    public void setProjectId(Long projectId) {
        ProjectId = projectId;
    }

    public List<ProjectProduct> getProjectProduct() {
        return ProjectProduct;
    }

    public void setProjectProduct(List<ProjectProduct> projectProduct) {
        ProjectProduct = projectProduct;
    }

    
    


    
}
