package com.example.foodapps.domain.util

interface DomainMapper <Entity,DomainModel> {

    fun mapFromEntity(entity: Entity) : DomainModel

    fun mapToEntity(domainModel: DomainModel) : Entity
}